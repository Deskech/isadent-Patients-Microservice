# Patients Microservice

This microservice receives information about new patients, stores it, and also returns the patient's information via a POST request in the controller. It is also responsible for publishing events to the billing microservice to maintain the persistence of the patients.

## Table of Contents
- [Installation](#installation)
- [JavaDocs](#Documentation)
- [Examples](#Examples)
- [License](#license)

## Installation
1. Clone the repository:
   ```bash
## Prerequisites
- **Java 17**
- **Maven**
- **RabbitMQ**
- **MySQL**

## Documentation
## Examples

### New Patient Request
```http

Content-Type: application/json
```
```json
{
   "patientIdentification": 222222222,
   "patientDirection": "123 Main Street, Any town, USA",
   "patientName": "John Doe"
}

```
### Search patient's information

**Search the patient by name:**
```http
POST /patients/search-by-name

Content-Type: application/json
```
* Input:
 ```json
    {
   
   "patientName": "John Doe"
   
    }
```
* Output:
 ```json
    {
   "patientIdentification": 222222222,
   "patientDirection": "123 Main Street, Any town, USA",
   "patientName": "John Doe"
   
    }
```
**Search the patient by identification number:**
* Input:
 ```json
    {
   
   "patientIdentification": 222222222
   
    }
```
* Output:
 ```json
    {
   "patientIdentification": 222222222,
   "patientDirection": "123 Main Street, Any town, USA",
   "patientName": "John Doe"
}
```
## License