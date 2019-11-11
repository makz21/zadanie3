# GET /generate

Returns calendar events for current month and current year from [http://www.weeia.p.lodz.pl/](http://www.weeia.p.lodz.pl/) in `.ics` format.

# Resource URL

`http://localhost:8080/generate`

## Resource Information

|                |                          	|                         
|----------------|-------------------------------|
|Response formats|`ics` file           |
|Requires authentication?         |No            |


# Example Request

`GET localhost:8080/generate`

# Example .ics Response 

```
BEGIN:VCALENDAR
PRODID:-//Ben Fortuna//iCal4j 1.0//EN
VERSION:2.0
CALSCALE:GREGORIAN
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191206T222313
SUMMARY:First Step to Nobel Prize
UID:6a2de177-9376-49ec-aef9-ec05eaa2968e
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191209T222313
SUMMARY:First Step to Fields Medal
UID:c77abd23-9196-474f-ba08-9334e6a6f923
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191211T222313
SUMMARY:Fascynująca Fizyka - poziom ponadpodstawowy
UID:9b8e83cc-a15f-4945-90f6-4ab469fea768
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191216T222313
SUMMARY:Matura próbna Matematyka podstawowa
UID:3c09e7a3-6ef9-44d0-a4b7-b152a32b55e7
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191217T222313
SUMMARY:Matura próbna Matematyka rozszerzona
UID:084c1b5b-69da-4822-89f2-bfb2aa787131
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191218T222313
SUMMARY:Matura próbna Fizyka rozszerzona
UID:4fe0ebac-f9a1-4c87-8a2a-e1c0409423c9
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191219T222313
SUMMARY:Matura próbna Chemia rozszerzona
UID:d652080a-eec5-44ac-aaea-bdeca0bbe300
END:VEVENT
END:VCALENDAR

```

# GET /generate-for-month

Returns calendar events for passed month in param and current year from [http://www.weeia.p.lodz.pl/](http://www.weeia.p.lodz.pl/) in `.ics` format.

# Resource URL

`http://localhost:8080/generate-for-month`

## Resource Information

|                |                          	|                         
|----------------|-------------------------------|
|Response formats|`ics` file           |
|Requires authentication?         |No            |



## Parameters
|     Name           |Required                          |Description                         | Example |
|----------------|-------------------------------|-----------------------------|------------------|
|month          |required             |A month for which calendar will be generated           |12

# Example Request
`GET localhost:8080/generate-for-month?month={montIntValue}`

`GET localhost:8080/generate-for-month?month=12`

# Example .ics Response 

```
BEGIN:VCALENDAR
PRODID:-//Ben Fortuna//iCal4j 1.0//EN
VERSION:2.0
CALSCALE:GREGORIAN
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191206T222313
SUMMARY:First Step to Nobel Prize
UID:6a2de177-9376-49ec-aef9-ec05eaa2968e
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191209T222313
SUMMARY:First Step to Fields Medal
UID:c77abd23-9196-474f-ba08-9334e6a6f923
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191211T222313
SUMMARY:Fascynująca Fizyka - poziom ponadpodstawowy
UID:9b8e83cc-a15f-4945-90f6-4ab469fea768
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191216T222313
SUMMARY:Matura próbna Matematyka podstawowa
UID:3c09e7a3-6ef9-44d0-a4b7-b152a32b55e7
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191217T222313
SUMMARY:Matura próbna Matematyka rozszerzona
UID:084c1b5b-69da-4822-89f2-bfb2aa787131
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191218T222313
SUMMARY:Matura próbna Fizyka rozszerzona
UID:4fe0ebac-f9a1-4c87-8a2a-e1c0409423c9
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191219T222313
SUMMARY:Matura próbna Chemia rozszerzona
UID:d652080a-eec5-44ac-aaea-bdeca0bbe300
END:VEVENT
END:VCALENDAR
```

# GET /generate-for-year-and-month

Returns calendar events for month and current year passed in param from [http://www.weeia.p.lodz.pl/](http://www.weeia.p.lodz.pl/) in `.ics` format.

# Resource URL

`http://localhost:8080/generate-for-year-and-month`

## Resource Information

|                |                          	|                         
|----------------|-------------------------------|
|Response formats|`ics` file           |
|Requires authentication?         |No            |



## Parameters
|     Name           |Required                          |Description                         | Example |
|----------------|-------------------------------|-----------------------------|------------------|
|year|required            | A year for which calendar will be generated                      | 2019
|month          |required             |A month for which calendar will be generated           |12
# Example Request
`GET localhost:8080/generate-for-year-and-month?year={yearValue}&month={monthValue}`

`GET localhost:8080/generate-for-year-and-year=2019&month=12`

# Example .ics Response 

```
BEGIN:VCALENDAR
PRODID:-//Ben Fortuna//iCal4j 1.0//EN
VERSION:2.0
CALSCALE:GREGORIAN
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191206T222313
SUMMARY:First Step to Nobel Prize
UID:6a2de177-9376-49ec-aef9-ec05eaa2968e
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191209T222313
SUMMARY:First Step to Fields Medal
UID:c77abd23-9196-474f-ba08-9334e6a6f923
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191211T222313
SUMMARY:Fascynująca Fizyka - poziom ponadpodstawowy
UID:9b8e83cc-a15f-4945-90f6-4ab469fea768
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191216T222313
SUMMARY:Matura próbna Matematyka podstawowa
UID:3c09e7a3-6ef9-44d0-a4b7-b152a32b55e7
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191217T222313
SUMMARY:Matura próbna Matematyka rozszerzona
UID:084c1b5b-69da-4822-89f2-bfb2aa787131
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191218T222313
SUMMARY:Matura próbna Fizyka rozszerzona
UID:4fe0ebac-f9a1-4c87-8a2a-e1c0409423c9
END:VEVENT
BEGIN:VEVENT
DTSTAMP:20191111T212313Z
DTSTART:20191219T222313
SUMMARY:Matura próbna Chemia rozszerzona
UID:d652080a-eec5-44ac-aaea-bdeca0bbe300
END:VEVENT
END:VCALENDAR
```
