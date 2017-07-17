CREATE DATABASE IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8 ;

USE `shop`;

CREATE TABLE `shop`.`categories` (
  `category_id` INT(5) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) CHARACTER SET 'utf8' NULL,
  PRIMARY KEY (`category_id`));
  
INSERT INTO categories (name) 
VALUES ('ALL'), ('VIDEOCARD'), ('CPU'), ('MOTHERBOARD'),
	   ('MEMORY'), ('HDD'), ('POWER'), ('SOUNDCARD');

CREATE TABLE `shop`.`items` (
  `item_id` INT(5) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  `rank` INT(2) NULL DEFAULT 0,
  `category_id` INT(5) NOT NULL,
  PRIMARY KEY (`item_id`),
  INDEX `category_id_idx` (`category_id` ASC),
  CONSTRAINT `category_id` 
	FOREIGN KEY (`category_id`) 
    REFERENCES `shop`.`categories` (`category_id`)
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8;
    
CREATE TABLE `shop`.`users` (
  `user_id` INT(5) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
DEFAULT CHARACTER SET = utf8;

INSERT INTO users (login, password) 
VALUES ('petrykin', 'petrykin'), ('milkina', 'milkina');

CREATE TABLE `shop`.`buckets` (
  `user_id` INT(5) NOT NULL,
  `item_id` INT(5) NOT NULL,
  `quantity` INT(100) NOT NULL DEFAULT 1,
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `item_id_idx` (`item_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `shop`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `shop`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8;

INSERT INTO items (name, cost, rank, category_id) 
VALUES ('Gigabyte GeForce GTX 1060 Windforce OC 3G 1797MHz', 12232.0, 5, 2),
	   ('MSI GeForce GTX 1060 Gaming X 6G 1809MHz (912-V328-006)', 13822.0, 6, 2),
       ('MSI GeForce GTX 1050 Ti Gaming X 4G 1379MHz (912-V335-005)', 7467.0, 9, 2),
       ('Gigabyte Radeon RX 570 Gaming 4G 1255MHz (GV-RX570GAMING-4GD)', 17324.0, 8, 2),
       ('MSI GeForce GTX 1060 3GT OC 1759MHz (912-V809-2226)', 11974.0, 3, 2),
       ('MSI GeForce GTX 1070 Gaming X 8G 1771MHz (912-V330-009)', 22279.0, 10, 2),
       ('Palit GeForce GTX 1060 Dual 3GB 1708MHz (NE51060015F9-1061D)', 11224.0, 7, 2),
       ('MSI GeForce GTX 1060 Gaming X 3G 1809MHz (912-V328-014)', 12747.0, 5, 2),
       ('Gigabyte GeForce GTX 1050 Ti OC 4G 1341MHz (GV-N105TOC-4GD)', 6166.0, 3, 2),
       ('Gigabyte GeForce GTX 1070 G1 Gaming 8G 1822MHz (GV-N1070G1 GAMING-8GD)', 19450.0, 7, 2),
       ('MSI GeForce GTX 1060 Gaming 6G 1746MHz', 16123.0, 8, 2),
       ('Gigabyte GeForce GTX 1050 Ti G1 Gaming 4G 1392MHz', 6248.0, 2, 2),
       ('MSI GeForce GTX 1050 Ti 4GT OC 1341MHz', 5949.0, 3, 2),
       ('MSI GeForce GTX 1060 Armor 3G OCV1 1759MHz (912-V328-024)', 12228.0, 5, 2),
       ('Sapphire Radeon RX 580 Pulse 1366MHz (11265-05-20G)', 14300.0, 7, 2),
       ('Asus GeForce GTX 1060 OC Dual 1594MHz (DUAL-GTX1060-O6G)', 13606.0, 6, 2),
       ('MSI GeForce GTX 1080 Ti Gaming X 11G 1569MHz', 29875.0, 9, 2),
       ('Asus GeForce GTX 1050 Ti ROG Strix 1290MHz', 5948.0, 2, 2),
       ('Gigabyte GeForce GTX 1050 Ti Windforce OC 4G 1354MHz (GV-N105TWF2OC-4GD)', 6247.0, 8, 2),
       ('Asus GeForce GTX 1070 OC ROG Strix 1657MHz', 20163.0, 8, 2),
       ('Intel Pentium G4560 Kaby Lake-S 3500Mhz', 2064.0, 8, 3),
       ('Intel Core i7-7700K Kaby Lake-S 4200Mhz', 10298.0, 9, 3),
       ('AMD Ryzen 5 1600 Summit Ridge 3200Mhz', 6793.0, 5, 3),
       ('Intel Celeron G3900 Skylake-S 2800Mhz', 1238.0, 3, 3),
       ('Intel Core i5-7400 Kaby Lake-S 3000Mhz', 5259.0, 7, 3),
       ('AMD Ryzen 5 1400 Summit Ridge 3200Mhz', 4900.0, 6, 3),
       ('Intel Core i3-7100 Kaby Lake-S 3900Mhz', 3425.0, 4, 3),
       ('Intel Pentium G4400 Skylake-S 3300Mhz', 1603.0, 3, 3),
       ('Intel Core i7-6700K Skylake-S 4000Mhz', 9798.0, 9, 3),
       ('AMD FX-8300 Vishera 3300Mhz', 2774.0, 6, 3),
       ('Intel Celeron G3930 Kaby Lake-S 2900Mhz', 1268.0, 4, 3),
       ('Intel Core i7-7700 Kaby Lake-S 3600Mhz', 8972.0, 7, 3),
       ('AMD FX-8350 Vishera 4000Mhz', 4041.0, 5, 3),
       ('Intel Celeron G1840 Haswell 2800Mhz', 1072.0, 7, 3),
       ('Intel Core i3-6100 Skylake-S 3700Mhz', 3289.0, 8, 3),
       ('AMD Ryzen 5 1500X Summit Ridge 3500Mhz', 5694.0, 9, 3),
       ('Intel Pentium G4620 Kaby Lake-S 3700Mhz', 2688.0, 7, 3),
       ('AMD FX-6300 Vishera 3500Mhz', 2382.0, 2, 3),
       ('AMD Ryzen 7 1800X Summit Ridge 3600Mhz', 14114.0, 6, 3),
       ('Intel Core i5-7600 Kaby Lake-S 3500Mhz', 6711.0, 7, 3),
       ('Asus H110M-K', 1490.0, 1, 4),
       ('ASRock H81 Pro BTC R2.0', 4245.0, 3, 4),
       ('Asus Prime Z270-P', 4675.0, 5, 4),
       ('Gigabyte GA-970A-DS3P', 2821.0, 6, 4),
       ('Asus Prime B250-Plus', 2707.0, 8, 4),
       ('Asus Prime H270-Plus', 4531.0, 3, 4),
       ('MSI H110M Pro-D', 1394.0, 7, 4),
       ('Asus Prime B350-Plus', 2969.0, 5, 4),
       ('ASRock N68-GS4 FX', 1128.0, 6, 4),
       ('MSI B250M Pro-VDH', 2233.0, 3, 4),
       ('Asus Prime B250M-K', 2032.0, 3, 4),
       ('MSI B350M Gaming Pro', 2421.0, 4, 4),
       ('Gigabyte GA-Z170-Gaming K3', 3601.0, 8, 4),
       ('ASRock H110M-DGS R3.0', 1357.0, 7, 4),
       ('Sapphire PB-CI7S42P67', 1880.0, 6, 4),
       ('Gigabyte GA-Z270P-D3', 3616.0, 8, 4),
       ('Asus Prime B250M-A', 2273.0, 2, 4),
       ('Asus H110M-R', 1449.0, 4, 4),
       ('Gigabyte GA-990X-Gaming SLI', 2879.0, 3, 4),
       ('ASRock Z97 Anniversary', 2455.0, 4, 4),
       ('Kingston KVR16N11S8/4', 883.0, 4, 5),
       ('Kingston HX421C14FB/8', 2044.0, 6, 5),
       ('Team Group TED48G2133C1501', 1670.0, 7, 5),
       ('Team Group TED44G2133C1501', 907.0, 3, 5),
       ('Samsung M378B5663QZ3-CF7', 616.0, 7, 5),
       ('Team Group TED416G2400C1601', 3237.0, 8, 5),
       ('Corsair CMK16GX4M2B3000C15', 3497.0, 6, 5),
       ('Kingston HX424C15FB2/8', 2054.0, 6, 5),
       ('Team Group TED48G2400C1601', 1687.0, 4, 5),
       ('Crucial CT8G4DFS8213', 1773.0, 8, 5),
       ('Kingston KVR16N11/8', 1664.0, 5, 5),
       ('Samsung M378B5173QH0-CK0', 788.0, 6, 5),
       ('GoodRAM GYS1866D364L9AS/8GDC', 1537.0, 8, 5),
       ('GoodRAM GR2133D464L15S/4G', 905.0, 8, 5),
       ('Hynix HMT451S6BFR8A-PB', 875.0, 6, 5),
       ('Patriot PSD32G16002', 415.0, 2, 5),
       ('Team Group TPRD416G2400HC16DC01', 3446, 8, 5),
       ('Kingston HX316C10FK2/8', 2083.0, 5, 5),
       ('Samsung M471B5173DB0-YK0', 876.0, 3, 5),
       ('AMD R744G2133U1S-U', 926.0, 4, 5),
       ('Western Digital Caviar Blue 1 TB', 1354.0, 4, 6),
       ('Transcend StoreJet 25M3 1 TB (TS1TSJ25M3)', 1863.0, 5, 6),
       ('Samsung 850 Evo 250 GB (MZ75E250BW)', 2873.0, 6, 6),
       ('Samsung 750 Evo 120 GB (MZ750120BW)', 1740.0, 3, 6),
       ('Seagate DB35 160 GB (ST3160212ACE)', 242.0, 2, 6),
       ('Kingston HyperX Fury 120 GB (SHFS37A/120G)', 1885.0, 6, 6),
       ('Kingston SSDNow V300 120 GB (SV300S37A/120G)', 1710.0, 7, 6),
       ('Toshiba Canvio Basics 1 TB (HDTB310EK3AA)', 1567.0, 7, 6),
       ('Kingston SSDNow UV400 120 GB (SUV400S37/120G)', 1583.0, 7, 6),
       ('ADATA Ultimate SU800 512 GB (ASU800NS38-512GT-C)', 4957.0, 8, 6),
       ('Western Digital AV-GP 500 GB (WD5000AVDS)', 776.0, 6, 6),
       ('Toshiba 1 TB (DT01ACA100)', 1234.0, 5, 6),
       ('Seagate Barracuda 1 TB (ST1000DM010)', 1349.0, 7, 6),
       ('Samsung 960 Evo M.2 250 GB (MZV6E250BW)', 4070.0, 6, 6),
       ('Western Digital AV-GP 1 TB (WD10EURX)', 1117.0, 4, 6),
       ('Western Digital Elements 1 TB (WDBUZG0010BBK)', 1680.0, 5, 6),
       ('Western Digital Caviar Blue 320 GB (WD3200AAJS)', 436.0, 6, 6),
       ('Samsung (Seagate) M3 Portable 1 TB (STSHX-M101TCB)', 1708.0, 8, 6),
       ('Samsung 850 Pro Series 256 GB (MZ7KE256BW)', 3836.0, 9, 6),
       ('Western Digital Blue 1 TB (WD10JPVX)', 1528.0, 3, 6),
       ('Chieftec CPS-750S 750W', 2509.0, 3, 7),
       ('Chieftec CTG-750C 750W', 2612.0, 4, 7),
       ('Chieftec GDP-750C 750W', 3843.0, 5, 7),
       ('Chieftec GPM-1250C 1250W', 9695.0, 8, 7),
       ('Chieftec GPS-750C 750W', 3959.0, 6, 7),
       ('Chieftec GPS-700A8 700W', 1586.0, 4, 7),
       ('Chieftec GPC-700S 700W', 1642.0, 5, 7),
       ('Corsair CX750 750W', 3580.0, 5, 7),
       ('GameMax GM-500 500W', 605.0, 5, 7),
       ('Aerocool KCAS 600W', 1567.0, 7, 7),
       ('Aerocool VX700 700W', 1348.0, 4, 7),
       ('Aerocool VX750 750W', 2121.0, 6, 7),
       ('FSP Group Q-Dion 750W (QD750)', 1657.0, 8, 7),
       ('Aerocool VX500 500W', 864.0, 3, 7),
       ('Chieftec APS-650SB 650W', 1778.0, 6, 7),
       ('Aerocool KCAS 700W', 2045.0, 8, 7),
       ('Zalman ZM700-TX 700W', 2908.0, 5, 7),
       ('Deepcool DE530 530W', 777.0, 7, 7),
       ('LogicPower ATX-450W OEM', 492.0, 2, 7),
       ('GameMax GM-400 400W', 404.0, 2, 7),
       ('Dynamode C-Media 108 USB (USB-SOUND7)', 126.0, 3, 8),
       ('Dynamode C-Media 3D USB (USB-SOUNDCARD2.0)', 110.0, 2, 8),
       ('Asus Xonar DG (90-YAA0K0-0UBN0BZ)', 834.0, 4, 8),
       ('Creative X-Fi Surround 5.1 Pro (SB1095)', 1792.0, 5, 8),
       ('Manli M-CMI8738-4CH', 172.0, 2, 8),
       ('Asus Xonar DGX (90-YAA0Q0-0UAN0BZ)', 1077.0, 6, 8),
       ('Creative SB ZXR 5.1', 5798.0, 8, 8),
       ('Creative SB Play! 2 (SB1620)', 872.0, 6, 8),
       ('Asus Xonar Essence STX (90-YAA0C0-0UAN00Z)', 5615.0, 7, 8),
       ('Creative Audigy SE (SB0570)', 703.0, 5, 8),
       ('Creative X-Fi HD USB (SB1240)', 2700.0, 7, 8),
       ('Asus Xonar U3 (90-YAB620B-UAN0BZ)', 858.0, 5, 8),
       ('Asus Xonar Essence STX II 7.1 (90YA00NN-M0UA00)', 8064.0, 8, 8),
       ('Asus Xonar U5 (90YB00FB-M0UC00)', 1808.0, 6, 8),
       ('Creative SB Surround 5.1 VX (SB1070)', 653.0, 4, 8),
       ('Asus Xonar DS (90-YAA0F0-0UAN00Z)', 1166.0, 6, 8),
       ('Asus Xonar U7 (90YB00AB-M0UC00)', 2751.0, 5, 8),
       ('Asus Xonar Essence STU (90YB007B-M0UC10)', 11117.0, 8, 8),
       ('Asus Xonar H6', 988.0, 3, 8),
       ('Creative X-Fi Titanium HD (SB1270)', 4783.0, 7, 8);

INSERT INTO buckets (user_id, item_id)
VALUES (1, 108), (1, 15), (1, 99), (1, 139), (1, 56), (1, 63), (1, 35);