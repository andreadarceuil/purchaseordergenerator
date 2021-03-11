INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email)VALUES ('123 Maple St','London','On', 'N1N-1N1','(555)555-5555','Trusted','ABC Supply Co.','abc@supply.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('543 Sycamore Ave','Toronto','On', 'N1P-1N1','(999)555-5555','Trusted','Big Bills Depot','bb@depot.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('922 Oak St','London','On', 'N1N-1N1','(555)555-5599','Un Trusted','Shady Sams','ss@underthetable.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('922 Oak St','London','On', 'N1N-1N1','(555)555-5599','Un Trusted','Andrea Darceuil','ad@netninja.com');

-- add expense categories
--INSERT INTO Product_Category (Id, Description) VALUES ('BSM','Business Meetings');
--INSERT INTO Product_Category (Id, Description) VALUES ('ENT','Entertainment');
--INSERT INTO Product_Category (Id, Description) VALUES ('PARK','Parking');
--INSERT INTO Product_Category (Id, Description) VALUES ('LDG','Lodging');
--INSERT INTO Product_Category (Id, Description) VALUES ('TRAV','Travel');
--INSERT INTO Product_Category (Id, Description) VALUES ('MEAL','Meals');
--INSERT INTO Product_Category (Id, Description) VALUES ('TUI','Tuition');
--INSERT INTO Product_Category (Id, Description) VALUES ('MISC','Miscealleous');
--INSERT INTO Product_Category (Id, Description) VALUES ('OTH','OTHER');
-- add some expenses to seed the table
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK389', 1,'Fridge',125.00,1850.50,20,40,30,5, 'xas1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK390', 1,'Microwave',25.00,900.50,15,30,25,5, 'yas1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK391', 1,'Stove',75.00,1400.25,10,20,16,5, 'xxs1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK392', 2,'Washer',50.00,1000.00,15,30,20,5, 'zax1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK393', 2,'Dryer',60.00,1100.00,20,100,15,5, 'xys1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK394', 2,'Dishwasher',30.00,800.00,20,40,25,5, 'xyz1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK841', 3,'Bicycle',20.00,600.00,20,40,20,5, 'xyz1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK842', 3,'Wheel',30.00,650.00,20,40,22,5, 'xyz1234hy4r');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AK843', 3,'Brake',35.00,300.00,20,40,23,5, 'xyz1234hy479');

INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AD841', 4,'Fiber-glass',20.00,600.00,20,40,20,5, 'xyz1234hy4');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AD842', 4,'Battery',30.00,650.00,20,40,22,5, 'xyz1234hy4r');
INSERT INTO Product (Id, VendorId,Name,CostPrice,MSRP,rop,eoq,qoh,qoo, qrcodetext)
VALUES ('AD843', 4,'Motor',35.00,300.00,20,40,23,5, 'xyz1234hy479');
