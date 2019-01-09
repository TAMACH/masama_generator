drop table if exists A;
drop table if exists B;
drop table if exists C;

CREATE TABLE A
(    
	A1 INT  unique ,
	A2 date  PRIMARY KEY,
	FOREIGN KEY (A1) REFERENCES B (B1)	
);
CREATE TABLE B
(    
   	B1 INT PRIMARY KEY,	
	B2 real ,	
	FOREIGN KEY (B1) REFERENCES C (C1)
);
CREATE TABLE C
(    	
	C1 INT PRIMARY KEY	,
	B2 boolean ,
	B2 BLOB  
);

insert into C values(3,"fx3485FA3D");
insert into B values(3,3);
insert into A values(3,"2017-09-05");

select * from A;
select * from B;
select * from C;

