CREATE TABLE IF NOT EXISTS WALLETS (
                                       ID BIGINT AUTO_INCREMENT NOT NULL,
                                       BALANCE DECIMAL(38, 2) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    "PASSWORD" VARCHAR(255) NOT NULL,
    REGISTRY VARCHAR(255) NOT NULL,
    "TYPE" VARCHAR(6) CHECK ("TYPE" IN ('SELLER', 'USER')) NOT NULL,
    PRIMARY KEY (ID),
    UNIQUE (EMAIL),
    UNIQUE (REGISTRY)
);