DROP TABLE Disease_Record_Symptoms;

DROP TABLE VRecord;
DROP TABLE Disease_Record;
DROP TABLE Predation_Record;
DROP TABLE VACCINATION_RECORD;
DROP TABLE BENEFICIARY;
DROP TABLE COMMUNITY;


CREATE TABLE COMMUNITY
(
    CName VARCHAR(40) NOT NULL PRIMARY KEY,
    Alias VARCHAR(40) NOT NULL,
    Country VARCHAR(40) NOT NULL,
    Province VARCHAR(40) NOT NULL,
    District VARCHAR(40) NOT NULL,
    GPSLat DECIMAL NOT NULL,
    GPSLong DECIMAL NOT NULL,
    Area DECIMAL NOT NULL,
    ForestArea DECIMAL NOT NULL,
    PastureLand DECIMAL NOT NULL,
    Protection_Status VARCHAR(19) NOT NULL
);

INSERT INTO COMMUNITY
VALUES
    ('Gurez Valley', 'alias', 'Pakistan', 'Kashmir', 'district', '-678.9', '234.9', '45000', '32000', '15000', 'protected');

-- Repeat for other tables

CREATE TABLE BENEFICIARY
(
    BId INT IDENTITY(1,1) PRIMARY KEY,
    BName VARCHAR(40) NOT NULL,
    FatherName VARCHAR(40) NOT NULL,
    Village VARCHAR(40) NOT NULL,
    CName VARCHAR(40) NOT NULL,
    FOREIGN KEY (CName) REFERENCES COMMUNITY(CName)
);

CREATE TABLE VACCINATION_RECORD
(
    RID INT IDENTITY(1,1) PRIMARY KEY,
    VYear INT NOT NULL,
    Season VARCHAR(10) NOT NULL,
    VDate DATE NOT NULL,
    Vaccinater VARCHAR(40) NOT NULL,
    DONOR VARCHAR(40) NOT NULL,
    BAnimalSlaughtered INT NOT NULL,
    SAnimalSlaughtered INT NOT NULL,
    SheepSold INT NOT NULL,
    CattleSold INT NOT NULL,
    GoatSold INT NOT NULL,
    PerAnimalCost DECIMAL NOT NULL,
    BId INT NOT NULL,
    FOREIGN KEY (BId) REFERENCES BENEFICIARY(BId)
);

CREATE TABLE VRecord
(
    VaccID INT IDENTITY(1,1) PRIMARY KEY,
    VSheep INT NOT NULL,
    VGoat INT NOT NULL,
    VCattle INT NOT NULL,
    VDozoo_Yak INT NOT NULL,
    VOthers INT NOT NULL,
    VaccinationType VARCHAR(50) NOT NULL,
    RID INT NOT NULL,
    FOREIGN KEY (RID) REFERENCES VACCINATION_RECORD(RID)
);

CREATE TABLE Disease_Record
(
    DiseaseID INT IDENTITY(1,1) PRIMARY KEY,
    DSheep INT NOT NULL,
    DGoat INT NOT NULL,
    DCattle INT NOT NULL,
    DDozoo_Yak INT NOT NULL,
    DiseaseType VARCHAR(50) NOT NULL,
    DOthers INT NOT NULL,
    RID INT NOT NULL,
    FOREIGN KEY (RID) REFERENCES VACCINATION_RECORD(RID)
);

CREATE TABLE Predation_Record
(
    PredationID INT IDENTITY(1,1) PRIMARY KEY,
    PSheep INT NOT NULL,
    PGoat INT NOT NULL,
    PCattle INT NOT NULL,
    PDozoo_Yak INT NOT NULL,
    PerAminalCost DECIMAL NOT NULL,
    PredatorType VARCHAR(10) NOT NULL,
    POthers INT NOT NULL,
    RID INT NOT NULL,
    FOREIGN KEY (RID) REFERENCES VACCINATION_RECORD(RID)
);

CREATE TABLE Disease_Record_Symptoms
(
    Symptom VARCHAR(50) NOT NULL,
    DiseaseID INT NOT NULL,
    PRIMARY KEY (Symptom, DiseaseID),
    FOREIGN KEY (DiseaseID) REFERENCES Disease_Record(DiseaseID)
);


INSERT INTO BENEFICIARY
    (BNAME, FATHERNAME, VILLAGE, CNAME)
VALUES
    ('Muhammad Maskeen Lone', 'Sultan', 'Thangi', 'Gurez Valley');
-- Add other beneficiary rows similarly

INSERT INTO VACCINATION_RECORD
    (VYear, Season, VDate, Vaccinater, DONOR, BAnimalSlaughtered, SAnimalSlaughtered, SheepSold, CattleSold, GoatSold, PerAnimalCost, BId)
VALUES
    (2023, 'Summer', '2023-03-01', 'Ihsan Ullah', 'SLT', 4, 6, 1, 2, 3, 10000, 1);

-- Add other vaccination_record rows similarly

-- Sample data for VRecord
INSERT INTO VRecord
    (VSheep, VGoat, VCattle, VDozoo_Yak, VOthers, VaccinationType, RID)
VALUES
    (10, 5, 2, 1, 0, 'Vaccination Type A', 1);

-- Add other VRecord rows similarly

-- Sample data for Disease_Record
INSERT INTO Disease_Record
    (DSheep, DGoat, DCattle, DDozoo_Yak, DiseaseType, DOthers, RID)
VALUES
    (5, 2, 3, 0, 'Disease Type A', 1, 1);

-- Add other Disease_Record rows similarly

-- Sample data for Predation_Record
INSERT INTO Predation_Record
    (PSheep, PGoat, PCattle, PDozoo_Yak, PerAminalCost, PredatorType, POthers, RID)
VALUES
    (2, 1, 1, 0, 5000, 'Predator A', 0, 1);

-- Add other Predation_Record rows similarly

-- Sample data for Disease_Record_Symptoms
INSERT INTO Disease_Record_Symptoms
    (Symptom, DiseaseID)
VALUES
    ('Symptom 1', 1);
