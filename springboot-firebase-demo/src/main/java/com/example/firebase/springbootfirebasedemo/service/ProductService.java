package com.example.firebase.springbootfirebasedemo.service;

import org.springframework.stereotype.Service;

import com.example.firebase.springbootfirebasedemo.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.WriteResult;
import java.util.concurrent.*;
@Service
public class ProductService {

private static final String COLLECTION_NAME = "products";
	public String saveProduct(Product product) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
	ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture =	dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);
		
		
			return collectionApiFuture.get().getUpdateTime().toString();
		
	}
	
	public Product getProductDetails(String name) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);
		
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document  = future.get();
		
		Product product = null;
		if(document.exists()) {
			product = document.toObject(Product.class);
			return product ;
			
		}else {
			return null;
		}
		}
	
public String updateProduct(Product product) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
	ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture =	dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);
		
		
			return collectionApiFuture.get().getUpdateTime().toString();
		
	}

public String deleteProduct(String name) throws InterruptedException, ExecutionException {
	
	Firestore dbFirestore = FirestoreClient.getFirestore();
	
ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture =	dbFirestore.collection(COLLECTION_NAME).document(name).delete();
	
	
		return"Document with product ID"+name+"has been deleted Svuccessfully";
	
}
	}