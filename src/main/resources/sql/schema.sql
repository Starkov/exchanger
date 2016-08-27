CREATE TABLE "person" (
  id               serial       NOT NULL,
  "first_name"     VARCHAR(45)  NOT NULL,
  "middle_name"    VARCHAR(45),
  "last_name"      VARCHAR(45)  NOT NULL,
  "email"          VARCHAR(100) NOT NULL UNIQUE,
  "password"       VARCHAR(100) NOT NULL,
  "cell_phone"     VARCHAR(20)  NOT NULL,
  "creation_date"  TIMESTAMP    NOT NULL,
  "last_edit_date" TIMESTAMP    NOT NULL,
  "discriminator"  VARCHAR(255) NOT NULL,
	CONSTRAINT person_pk PRIMARY KEY ("id")

) WITH (
  OIDS=FALSE
);



CREATE TABLE "role" (
  "id"             serial      NOT NULL,
  "name"           VARCHAR(50) NOT NULL UNIQUE,
  "creation_date"  TIMESTAMP   NOT NULL,
  "last_edit_date" TIMESTAMP   NOT NULL,
	CONSTRAINT role_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "person_role" (
	"person_id" integer NOT NULL,
	"role_id" integer NOT NULL,
	CONSTRAINT person_role_pk PRIMARY KEY ("person_id","role_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "purse" (
	"id" serial NOT NULL,
	"number" VARCHAR(20) NOT NULL UNIQUE,
	"purse_type_id" integer NOT NULL,
	"currency_id" integer NOT NULL,
	"balance" numeric(24,6) NOT NULL,
	"person_id" integer NOT NULL,
	"creation_date" TIMESTAMP NOT NULL,
	"last_edit_date" TIMESTAMP NOT NULL,
	CONSTRAINT purse_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "transaction" (
  "id"                   serial        NOT NULL,
  "creation_date"        TIMESTAMP     NOT NULL,
  "last_edit_date"       TIMESTAMP     NOT NULL,
  "final_date"           TIMESTAMP,
  "amount"               numeric(24,6) NOT NULL,
  "action"               VARCHAR(20)   NOT NULL,
  "source_purse_id"      integer       NOT NULL,
  "destination_purse_id" integer       NOT NULL,
  "description"          VARCHAR(100),
  "status"               VARCHAR(20)   NOT NULL,
	CONSTRAINT transaction_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "purse_type" (
	"id" serial NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"creation_date" TIMESTAMP NOT NULL,
	"last_edit_date" TIMESTAMP NOT NULL,
	CONSTRAINT purse_type_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);


CREATE TABLE "name" (
	"id" serial NOT NULL,
	"name" varchar(45) NOT NULL UNIQUE,
	"creation_date" TIMESTAMP NOT NULL,
	"last_edit_date" TIMESTAMP NOT NULL,
	CONSTRAINT currency_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "commission" (
	"source_currency_id" integer NOT NULL,
	"destination_currency_id" integer NOT NULL,
	"amount" numeric(24,6) NOT NULL,
	"creation_date" TIMESTAMP NOT NULL,
	"last_edit_date" TIMESTAMP NOT NULL,
	CONSTRAINT commission_pk PRIMARY KEY ("source_currency_id","destination_currency_id")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "person_role" ADD CONSTRAINT "person_role_fk0" FOREIGN KEY ("person_id") REFERENCES "person"("id");
ALTER TABLE "person_role" ADD CONSTRAINT "person_role_fk1" FOREIGN KEY ("role_id") REFERENCES "role"("id");

ALTER TABLE "purse" ADD CONSTRAINT "purse_fk0" FOREIGN KEY ("purse_type_id") REFERENCES "purse_type"("id");
ALTER TABLE "purse"
  ADD CONSTRAINT "purse_fk1" FOREIGN KEY ("currency_id") REFERENCES "name" ("id");
ALTER TABLE "purse" ADD CONSTRAINT "purse_fk2" FOREIGN KEY ("person_id") REFERENCES "person"("id");

ALTER TABLE "transaction" ADD CONSTRAINT "transaction_fk0" FOREIGN KEY ("source_purse_id") REFERENCES "purse"("id");
ALTER TABLE "transaction" ADD CONSTRAINT "transaction_fk1" FOREIGN KEY ("destination_purse_id") REFERENCES "purse"("id");


ALTER TABLE "commission"
  ADD CONSTRAINT "commission_fk0" FOREIGN KEY ("source_currency_id") REFERENCES "name" ("id");
ALTER TABLE "commission"
  ADD CONSTRAINT "commission_fk1" FOREIGN KEY ("destination_currency_id") REFERENCES "name" ("id");

