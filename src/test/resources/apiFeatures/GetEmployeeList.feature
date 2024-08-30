Feature: Get User List from Gorest API

  @ApiRegression @UserListTest
Scenario: Get all users from endpoint
Given User gets Employee List from Gorest API
Then  Validate if status code is 200

  @ApiRegression @UserListTest
Scenario: Get unique user name from Gorest API
Given User gets Employee List from Gorest API
Then User retrieve and print unique Gorest user names


@ApiRegression @UserListTest
Scenario: Get only Male users
Given User gets Employee List from Gorest API
Then Find the first names whose gender is male
