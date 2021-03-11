package com.info5059.casestudy.po;
import com.info5059.casestudy.product.Product;
import com.info5059.casestudy.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.Optional;

@Component
public class PurchaseOrderDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public Long create(PurchaseOrder clientpo)  {

        PurchaseOrder realPurchaseOrder = new PurchaseOrder();
        realPurchaseOrder.setPodate(new Date());
        realPurchaseOrder.setAmount(clientpo.getAmount());
        realPurchaseOrder.setVendorid(clientpo.getVendorid());
        entityManager.persist(realPurchaseOrder);
        for(PurchaseOrderLineItem item :clientpo.getItems()) {
            PurchaseOrderLineItem realItem = new PurchaseOrderLineItem();
            realItem.setPoid(realPurchaseOrder.getId());
            realItem.setProductid(item.getProductid());
            realItem.setQty(item.getQty());
            Optional<Product> prod = productRepository.findById(item.getProductid());
            if(prod.isPresent()){
                Product product = prod.get();
                product.setQoo(item.getQty());
                //realItem.setProductQty(product, item.getQty());
            }
            realItem.setPrice(item.getPrice());
            entityManager.persist(realItem);
        }
        return realPurchaseOrder.getId();
    }
    public PurchaseOrder findOne(Long id) {
        PurchaseOrder po = entityManager.find(PurchaseOrder.class, id);
        if (po == null) {
            throw new EntityNotFoundException("Can't find report for ID "
                    + id);
        }
        return po;
    }
    public Iterable<PurchaseOrder> findByVendor(Long vendorId) {
        return entityManager.createQuery("select p from PurchaseOrder p where p.vendorid = :id")
                .setParameter("id", vendorId)
                .getResultList();
    }
    public Iterable<PurchaseOrder> findAll(){
        return entityManager.createQuery("select Id, vendorid, podate,  items from PurchaseOrder")
                .getResultList();
    }
}
