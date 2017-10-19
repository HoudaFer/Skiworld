package skiworld.services;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import skiworld.persistence.Category;
import skiworld.persistence.Product;
import skiworld.persistence.Shop;


@Stateless
public class ShopManager implements IShopManager{
	@PersistenceContext
	EntityManager em;
	@Override
	public void AddProduct(Product product) {
		
			em.persist(product);
			
	}

	@Override
	public void DeleteProduct(Product product) {
		em.remove(em.merge(product));
		
	}

	@Override
	public void UpdateProduct(Product product) {
		
			em.merge(product);
			
		
	}

	@Override
	public void affectProductToCategory(Category category, Product product) {
		
		//product =em.find(Product.class, product.getIdProduct());
		//product.setCategory(category);
		 
		    	
		product.setCategory(category);
		em.persist(product);
		
	}

	@Override
	public Product findProduct(int id) {
		Product p = em.find(Product.class, id);
		return p;
	}

	@Override
	public List<Product> ListProduct() {
	
			Query q=em.createQuery("select p from Product p ");
			return q.getResultList();
		
	}

	@Override
	public void AddCategory(Category category) {
		em.persist(category);
		
	}

	@Override
	public void DeleteCategory(Category category) {
		//em.remove(em.merge(category));
		
		
		
		category = em.find(Category.class, category.getIdCategory());
		// il faut supprimer le bout master d'abord
		 for (Product P : category.getProduct()) {
		 em.remove(P);
	}
		 em.remove(em.merge(category));
		
	}

	@Override
	public void UpdateCategory(Category category) {
		em.merge(category);	
	}

	@Override
	public Product findCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> ListCategory() {
		Query q=em.createQuery("select p from Category p ");
		return q.getResultList();
	}

	@Override
	public List<Product> ListProductByCategory() {
		
			
			Query query= em.createQuery("select e from Product e where e.name=:l ");
			query.setParameter("l", "prod");
		    return query.getResultList();
	}

	@Override
	public List<Shop> ListShop() {
		Query q=em.createQuery("select p from Shop p ");
		return q.getResultList();
	}

	@Override
	public List<Product> ListProductPrice() {
		Query query= em.createQuery("SELECT p FROM Product p WHERE p.name LIKE 'sp%' ");
		
	    return query.getResultList();
	}

	@Override
	public boolean deleteProductById(int id) {
		Iterator<Product> iterator=ListProduct().iterator();
		while(iterator.hasNext()){
			Product p=iterator.next();
			if(p.getIdProduct()==id){
				em.remove(p);
				return true;
			}
		}
		return false;

	}
	}


