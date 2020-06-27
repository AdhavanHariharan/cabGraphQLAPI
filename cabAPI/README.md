# graphql-java-spring-boot-project

Required:

Java 8,
MySQL

Steps to run the project:

1. Import the project in STS.
2. Connect to MySQL and create a schema named testdb
3. Run the application and tables will be created in the testdb schema.
4. Then import the dump file present in Artifacts/ CabTableExport.csv in cab table.
		This step is to find the cab that is nearby. Some area names are loaded into the database so that user can request(API1) and searchcab(API3).
		!NOTE: without importing the dump file APIs will throw error.
5. After importing the file hit the http://localhost:8080/graphql.
6. API1:
	A user should be able to request a booking for a cab from pickup location  A to pickup location B
	Request:
		mutation {
		  newBooking(
			carType: "Sedan",
			source: "Ambattur",
			destination:"Vadapalani"
			user: "Akaash") {
			  carType
				source
				destination
				user{
				name
			  }
		  }}
		  
	API2:
	A user should be able to view his past bookings.
	
	Request:
		query findBookings($name:String!){                          
		  findBookings(name:$name){
			carType
			destination
			}}
	Query Variables:
        {"name": "Akaash"}
		
	API 3:
	
	A User should be able to get cabs that are nearby
	
	Request:
		query findCab($area:String!,$carType:String!){
		  findCab(area:$area,carType:$carType){
			carType
			cabId
			distance
			
			}
		}

	Query Variables:
			{
			  "area": "Porur",
			  "carType": "SUV"
		    }




