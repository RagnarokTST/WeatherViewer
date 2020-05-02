# WeatherViewer

WEB APP provides current weather in different locations.

Webpage creates request to selected weather-API in each case of:
1. Opening page
2. Refresh page
3. Using "Refresh" button
5. Timeout. Webpage reloads every 5 minutes (using "http-equiv" attribute with "refresh" content)

Using several APIs:
1. weatherstack
2. Яндекс.Погода

APP provides 3 types of data:
1. Temperature
2. Humidity
3. Weather condition with corresponding image

APP dont use any SQL/NoSQL storage.
APP using COOKIE (2 fields) to save chosen service provider and location.
