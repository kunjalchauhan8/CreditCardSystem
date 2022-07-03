# CreditCardSystem
DemoSystem

1> Implemented Get API to get All credit Card DEtails
2> Implement POST API to push Credit card Details
3> In Post API added Validation for Luhn card check.
4> Added 2 Generic Test Cases due to time constraint.
5> Other Generic Validation done for mandatory filed.
i.e Mandatory filed
    Limit for credit card number


Note: UI in react is not done as i have Most backend experiance on Java and spring boot and due to short time limit react UI not managed with this task.

Example API for check:

1> For fetch all credit Details : http://localhost:8080/cards/api/credit/get
Username and password for basic authentication admin/admin

2> For Add credit Details:  http://localhost:8080/cards/api/credit/add
Username and password for basic authentication admin/admin

sample json to pass in body:
{
    "name":"Emma Watson",
    "card_number":79927398713,
    "credit_limit":100.00,
    "balance": 0.00    
}    
