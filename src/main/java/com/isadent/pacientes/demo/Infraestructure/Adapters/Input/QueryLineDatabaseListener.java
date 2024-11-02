package com.isadent.pacientes.demo.Infraestructure.Adapters.Input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Repository.Query.ReadPatientActualization;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueryLineDatabaseListener implements ChannelAwareMessageListener {
    private final ObjectMapper objectMapper;
    private final ReadPatientActualization actualization;

    public QueryLineDatabaseListener(ObjectMapper objectMapper, ReadPatientActualization actualization) {
        this.objectMapper = objectMapper;
        this.actualization = actualization;
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        ReadPatients readPatients = objectMapper.readValue(message.getBody(), ReadPatients.class);

        actualization.saveNewPatient(readPatients)
                .doOnSuccess(result -> {
                    try {
                        log.info("Message processed successfully for delivery tag:{}", deliveryTag);
                        channel.basicAck(deliveryTag, false);
                    } catch (Exception e) {
                        log.error("Failed to ack for delivery tag:{}", deliveryTag, e);
                    }
                }).doOnError(error -> {
                    try {
                        log.error("failed to process message for delivery tag:{}", deliveryTag);
                        channel.basicNack(deliveryTag, false, true);
                    } catch (Exception e) {
                        log.error("Failed to Nack for delivery tag :{}", deliveryTag, e);
                    }
                }).subscribe();
    }
}
