Feature: Get weather by city name 


@GetWeather1  @ApiRegression
Scenario: Post Once  validate multiple times
	Given User gets weather for "Washington DC"
	Then User validates response body has city "Washington D.C." for "$.name"
		
		
