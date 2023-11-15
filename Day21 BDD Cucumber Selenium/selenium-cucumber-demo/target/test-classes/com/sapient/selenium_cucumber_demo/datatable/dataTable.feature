Feature: Data table
	Verify that the new user registration is successful after passing correct inputs.
Scenario:
Given the user on the user registration page.
When user enter valid data on the page
| Fields   | Values              |
| FirstName              | Siva                |
| LastName               | OS                  |
| Email				           | syskantechnosoft@gmail.com   |
| Company								 | syskantechnosoft    |
| Functional Role        | IT                  |
| Job Level              | Faculty             |
| Company Size					 | 0-350							 |
| Country								 | India							 |

Then the user registration should be successful.