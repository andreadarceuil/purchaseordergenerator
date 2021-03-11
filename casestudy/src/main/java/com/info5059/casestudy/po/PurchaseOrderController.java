package com.info5059.casestudy.po;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderDAO poDAO;
    @PostMapping("/api/pos")
    public ResponseEntity<Long> addOne(@RequestBody PurchaseOrder clientpo) { // use RequestBody here
        Long poId = poDAO.create(clientpo);
        return new ResponseEntity<Long>(poId, HttpStatus.OK);
    }
    @GetMapping("/api/pos")public ResponseEntity<Iterable<PurchaseOrder>> findAll(){
        Iterable<PurchaseOrder> pos = poDAO.findAll();
        return new ResponseEntity<Iterable<PurchaseOrder>>(pos, HttpStatus.OK);
    }
    @GetMapping("/api/pos/{id}")
    public ResponseEntity<Iterable<PurchaseOrder>> findByVendorId(@PathVariable long id){
        Iterable<PurchaseOrder> vendorPos =  poDAO.findByVendor(id);
        return new ResponseEntity<Iterable<PurchaseOrder>>(vendorPos,HttpStatus.OK );
    }
}
