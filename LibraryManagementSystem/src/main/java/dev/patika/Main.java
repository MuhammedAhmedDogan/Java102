package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Author author = entityManager.find(Author.class,1);
        Category category = entityManager.find(Category.class,1);
        Publisher publisher = entityManager.find(Publisher.class,1);

        Book book = new Book();
        book.setName("Harry Potter and the Prisoner of Azkaban");
        book.setPublicationYear(1999);
        book.setStock(20);
        book.setPublisher(publisher);
        book.setAuthor(author);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        book.setCategoryList(categoryList);

        entityManager.persist(book);

        entityManager.getTransaction().commit();
    }
}