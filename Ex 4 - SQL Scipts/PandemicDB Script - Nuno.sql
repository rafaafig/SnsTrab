
CREATE TABLE Facility (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(255), -- Adjust the length as needed
    address_street VARCHAR2(255), -- Assuming Address has a 'street' field
    address_city VARCHAR2(255),   -- Assuming Address has a 'city' field
    address_zip VARCHAR2(20),     -- Assuming Address has a 'zip' field
    phone_number VARCHAR2(20),    -- Assuming Phone has a 'number' field
    phone_type VARCHAR2(20),       -- Assuming Phone has a 'type' field
    email_address VARCHAR2(255),  -- Assuming Email has an 'address' field
    fax_number VARCHAR2(20),       -- Assuming Phone (fax) has a 'number' field
    website_url VARCHAR2(255),     -- Assuming Website has a 'url' field
    opening_hour TIMESTAMP,        -- Assuming LocalTime is represented as TIMESTAMP
    closing_hour TIMESTAMP,        -- Assuming LocalTime is represented as TIMESTAMP
    max_vaccines_per_hour NUMBER
);


create table Pandemic (
ID_Pandemic PRIMARY KEY,
NamePandemic varchar(50) constraint nn NOT NULL
);
