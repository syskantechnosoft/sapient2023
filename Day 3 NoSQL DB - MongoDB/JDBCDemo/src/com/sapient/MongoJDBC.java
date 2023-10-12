package com.sapient;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("My First JDBC Program");

		// Step 1: Load & Register the Driver
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		// Step 2: Establish the connection
		MongoDatabase database = mongoClient.getDatabase("sapient");

		// Step 3 : Create & Execute Query
		// Display all the Databse in the MongoDB
		System.out.println("-------------List of Databases-------------------");
		mongoClient.listDatabaseNames().forEach(System.out::println);
		// Create Collection
//		database.createCollection("customers");
		// list collection
		System.out.println("-------------List of Collections-------------------");
		database.listCollectionNames().forEach(System.out::println);

		MongoCollection<Document> collection = database.getCollection("customers");
		Document document = new Document();
		document.put("name", "Shubham");
		document.put("company", "Sapient");
		collection.insertOne(document);

		// Read One Operation
		Document searchQuery = new Document();
		searchQuery.put("name", "Shubham");
		FindIterable<Document> cursor = collection.find(searchQuery);

		try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
			while (cursorIterator.hasNext()) {
				System.out.println(cursorIterator.next());
			}
		}

		// Step 4 : Process the Result

		// Step 5 : Disconnect

//		try {
//			// ---------- Connecting DataBase -------------------------//
//			MongoClient mongoClient = new MongoClient("localhost", 27017);
//			// ---------- Creating DataBase ---------------------------//
//			MongoDatabase db = mongoClient.getDatabase("javatpoint");
//			// ---------- Creating Collection -------------------------//
//			MongoCollection<Document> table = db.getCollection("employee");
//			// ---------- Creating Document ---------------------------//
//			Document doc = new Document("name", "Peter John");
//			doc.append("id", 12);
//			// ----------- Inserting Data ------------------------------//
////			table.insertOne(doc);
//		} catch (Exception e) {
//			System.out.println(e);
//		}

	}

}
