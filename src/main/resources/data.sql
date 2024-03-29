

/** Inserción de los valores generados para la consistencia del ejercicio**/
INSERT INTO BRAND (id, name) VALUES (1, 'ZARA');
INSERT INTO PRODUCT (id, name) VALUES (35455, 'Producto Test');


/** Inserción de los valores otorgados en el ejercicio **/
INSERT INTO PRICE (
    brand_id,
    start_date,
    end_date,
    price_list,
    product_id,
    priority,
    price,
    curr)
VALUES(
        1,
        parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
        parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss') ,
        1,
        35455,
        0,
        35.50,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'),
        parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss') ,
        2,
        35455,
        1,
        25.45,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'),
        parsedatetime('2020-06-15-11.00.00 ', 'yyyy-MM-dd-HH.mm.ss') ,
        3,
        35455,
        1,
        30.50,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'),
        parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss') ,
        4,
        35455,
        1,
        38.95,
        'EUR'
    );