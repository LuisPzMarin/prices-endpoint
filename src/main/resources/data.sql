INSERT INTO PRICE (
    brand_id,
    end_date,
    start_date,
    price_list,
    product_id,
    priority,
    price,
    curr)
VALUES(
        1,
        parsedatetime('2020-06-14-00.00.00', 'yyyy-mm-dd-hh.mm.ss'),
        parsedatetime('2020-12-31-23.59.59', 'yyyy-mm-dd-hh.mm.ss') ,
        1,
        35455,
        0,
        35.50,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-14-15.00.00', 'yyyy-mm-dd-hh.mm.ss'),
        parsedatetime('2020-06-14-18.30.00', 'yyyy-mm-dd-hh.mm.ss') ,
        2,
        35455,
        1,
        25.45,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-14-15.00.00', 'yyyy-mm-dd-hh.mm.ss'),
        parsedatetime('2020-06-15-11.00.00 ', 'yyyy-mm-dd-hh.mm.ss') ,
        3,
        35455,
        1,
        30.50,
        'EUR'
    ),
    (
        1,
        parsedatetime('2020-06-15-16.00.00', 'yyyy-mm-dd-hh.mm.ss'),
        parsedatetime('2020-12-31-23.59.59', 'yyyy-mm-dd-hh.mm.ss') ,
        4,
        35455,
        1,
        38.95,
        'EUR'
    );