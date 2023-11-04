do $$ 
declare marca_nombre varchar := 'APRILIA';
        marca_id int := 0;
        tipo_moto_id int := 0;
        tipo_auto_id int := 1;
        tipo_pickup_id int := 2;
        tipo_camion_id int := 3;

begin

    marca_id := (SELECT id FROM MARCA WHERE nombre = marca_nombre);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('150 STX',tipo_moto_id,marca_id,'2015',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('750 SHIVER',tipo_moto_id,marca_id,'2017',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('900 DORSODURO',tipo_moto_id,marca_id,'2018',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('900 SHIVER',tipo_moto_id,marca_id,'2018',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('1000 RSV4 RF',tipo_moto_id,marca_id,'2017',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('1000 RSV4 RR',tipo_moto_id,marca_id,'2017',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('1100 TUONO RF',tipo_moto_id,marca_id,'2017',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('1100 TUONO RR',tipo_moto_id,marca_id,'2017',NULL);

    INSERT INTO MODELO (nombre, tipo_vehiculo_id, marca_id, anio_desde, anio_hasta)
        VALUES ('1200 CAPONORD RALLY',tipo_moto_id,marca_id,'2017',NULL);

    
      
end$$