# hitss_tarea
Tarea de Global Hitss

Mis SP y consultas en Oracle:

crear tabla producto y crear el stored procedure:

select * from EMPLOYEES;

CREATE TABLE producto (
  id NUMBER(10) NOT NULL,
  nombre VARCHAR2(50) NOT NULL,
  codigo VARCHAR2(50) NOT NULL,
  precio NUMBER(10,2) NOT NULL,
  cantidad NUMBER(10) NOT NULL,
  marca VARCHAR2(50) NOT NULL,
  PRIMARY KEY (id)
);

-- insertas algunos datos en la tabla preoducto

INSERT INTO producto (id, nombre, codigo, precio, cantidad, marca) VALUES 
(1, 'Televisor LED 4K', '1234567890', 1500.00, 100, 'Samsung'),
(2, 'Laptop Core i7', '9876543210', 2500.00, 50, 'Dell'),
(3, 'Celular iPhone 13', '0987654321', 3500.00, 20, 'Apple')
(4, 'Nevera Samsung', '1234567891', 2000.00, 150, 'Samsung'),
(5, 'Cocina Whirlpool', '9876543211', 3000.00, 100, 'Whirlpool'),
(6, 'Lavadora LG', '0987654322', 2500.00, 50, 'LG'),
(7, 'Secadora Samsung', '1234567892', 2000.00, 20, 'Samsung'),
(8, 'Cafetera Nespresso', '9876543212', 1500.00, 100, 'Nespresso'), 
(9, 'Tostadora Oster', '0987654323', 500.00, 50, 'Oster'),
(10, 'Licuadora Oster', '1234567893', 750.00, 20, 'Oster'),
(11, 'Horno microondas Whirlpool', '9876543213', 1000.00, 100, 'Whirlpool'),
(12, 'Plancha Rowenta', '0987654324', 1250.00, 50, 'Rowenta'),
(13, 'Vacuum cleaner Dyson', '1234567894', 2500.00, 20, 'Dyson'),
(14, 'Juego de ollas Tramontina', '9876543214', 1500.00, 100, 'Tramontina'),
(15, 'Set de cubiertos Tramontina', '0987654325', 750.00, 50, 'Tramontina');


INSERT INTO producto (id, nombre, codigo, precio, cantidad, marca) VALUES
(1, 'Camiseta de algodón', 'COD001', 19.99, 100, 'Nike'),
(2, 'Zapatillas deportivas', 'COD002', 49.99, 50, 'Adidas'),
(3, 'Pantalones vaqueros', 'COD003', 39.95, 75, 'Levis'),
(4, 'Reloj analógico', 'COD004', 79.99, 30, 'Casio'),
(5, 'Portátil ultrabook', 'COD005', 899.99, 10, 'Dell'),
(6, 'Cámara digital DSLR', 'COD006', 699.50, 20, 'Canon'),
(7, 'Auriculares inalámbricos', 'COD007', 129.99, 40, 'Sony'),
(8, 'Mochila resistente al agua', 'COD008', 59.75, 60, 'The North Face'),
(9, 'Teclado mecánico para gaming', 'COD009', 109.99, 25, 'Logitech'),
(10, 'Libro de ciencia ficción', 'COD010', 14.50, 200, 'Random House'),
(11, 'Batería externa portátil', 'COD011', 29.99, 80, 'Anker'),
(12, 'Silla ergonómica de oficina', 'COD012', 149.95, 15, 'Steelcase'),
(13, 'Cepillo de dientes eléctrico', 'COD013', 39.50, 50, 'Oral-B'),
(14, 'Lámpara LED de escritorio', 'COD014', 24.99, 35, 'Philips'),
(15, 'Pinturas acrílicas set de 12 colores', 'COD015', 19.75, 50, 'Winsor & Newton');

select * from PRODUCTO;

-- creas el stored procedure

CREATE OR REPLACE PROCEDURE sp_ejemplo_hitss
AS
BEGIN
  -- Declaramos un cursor para recorrer los registros de la tabla
  DECLARE
    cur_producto CURSOR FOR
      SELECT id, nombre, codigo, precio, cantidad, marca
      FROM producto;

  -- Abrimos el cursor
  OPEN cur_producto;

  -- Recorremos el cursor y mostramos los datos de cada registro
  LOOP
    FETCH cur_producto INTO id, nombre, codigo, precio, cantidad, marca;
    EXIT WHEN cur_producto%NOTFOUND;

    -- Imprimimos los datos del registro actual
    DBMS_OUTPUT.PUT_LINE(
      'ID: ' || id || ', Nombre: ' || nombre || ', Código: ' || codigo ||
      ', Precio: ' || precio || ', Cantidad: ' || cantidad || ', Marca: ' || marca
    );
  END LOOP;

  -- Cerramos el cursor
  CLOSE cur_producto;
END;

-- ejecutando el sp:


DECLARE
   v_result SYS_REFCURSOR;
   v_id PRODUCTO.ID%TYPE;
   v_nombre PRODUCTO.NOMBRE%TYPE;
   v_codigo PRODUCTO.CODIGO%TYPE;
   v_precio PRODUCTO.PRECIO%TYPE;
   v_cantidad PRODUCTO.CANTIDAD%TYPE;
   v_marca PRODUCTO.MARCA%TYPE;
BEGIN
   -- Llamada al procedimiento almacenado sin la palabra clave EXECUTE
   SP_EJEMPLO_HITSS(v_result);

   LOOP
       FETCH v_result INTO v_id, v_nombre, v_codigo, v_precio, v_cantidad, v_marca;
       EXIT WHEN v_result%NOTFOUND;

       DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ', Nombre: ' || v_nombre || ', Código: ' || v_codigo ||
                           ', Precio: ' || v_precio || ', Cantidad: ' || v_cantidad || ', Marca: ' || v_marca);
   END LOOP;

   CLOSE v_result;
END;

ahi en consola debend de salir los datos del oracle sql developer.



--STORED QUE INSERTA UN PRODUCTO:

create or replace PROCEDURE SP_EJEM_HITSS_SAVE (
    p_producto_id IN PRODUCTO.ID%TYPE,
    p_nombre IN PRODUCTO.NOMBRE%TYPE,
    p_codigo IN PRODUCTO.CODIGO%TYPE,
    p_precio IN PRODUCTO.PRECIO%TYPE,
    p_cantidad IN PRODUCTO.CANTIDAD%TYPE,
    p_marca IN PRODUCTO.MARCA%TYPE    
   
)
AS
BEGIN
    INSERT INTO PRODUCTO (
        id,
        nombre,
        codigo,
        precio,
        cantidad,
        marca
        
    ) VALUES (
        p_producto_id,
        p_nombre,
        p_codigo,
        p_precio,
        p_cantidad,
        p_marca
    );
    
    COMMIT;
END;




e link del github:

https://github.com/chcamp/hitss_tarea.git
