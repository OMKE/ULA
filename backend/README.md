## University of Los Angeles Backend Services

Backend is done in microservice architecture, using Netflix OSS technologies

### Architecture

**ULA-DISCOVERY** - Eureka discovery service, finds all services and registers them so we can make intra service requests

**ULA-API-GATEWAY** - Netflix Zuul Api Gateway, used as Edge service which forwards requests by URL paths to intended services

**ULA-CORE** - Core library, holds files that are common between services, util classes and much more. It's hosted on Repsy so we only need to add dependency in service pom.xml file

**ULA-AUTHENTICATION** - Manages Authentication and Authorization

**ULA-STATIC-CONTENT-SERVICE** - Service that manages all static files (images, pdfs, videos)

**ULA-UNIVERSITY-SERVICE** - Service that manages University information (contact, gallery...)

**ULA-FACULTY-SERVICE** - Probably the most important service, it manages information about faculties, study programs, teachers, students, student grades... (\*note - this service can be even more distributed, maybe in future)

**ULA-EXAM-SERVICE** - Service that manages student exams

**ULA-TEACHER-SERVICE** - This is composite service which works with ULA-FACULTY-SERVICE and ULA-EXAM-SERVICE, manages all teacher's functionality

**ULA-STUDENT-SERVICE** - Composite service which works with ULA-FACULTY-SERVICE and ULA-EXAM-SERVICE, manages all student's functionality

**ULA-RESEARCH-SERVICE** - Service for Research works, Content creators are working with this service by publishing research works from teachers and students

\*Some services have private routes that are only accessible intra-service, they have 'private' in their path, netflix zuul blocks those routes from external access. This is done only for security concerns.  
example: /private/student/grades, /student/grades/private
...

<img src="https://user-images.githubusercontent.com/17277467/95518754-078f3d80-09c4-11eb-8831-180adf1968b4.png">
