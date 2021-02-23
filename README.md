Como correr el proyecto:
- Correr el archivo Docker compose para levanter el contenedor de la DB:
    docker-compose up -d
- Ejecutar la aplicación

Endpoints de la Api:
 - /process_file   --> Procesa el archivo ubicadoo en la ruta resources
 - /get_data  --> consulta con query param de ip_front y country

Explicación:

Por motivo de tiempo no pude finalizar ni optimizar la aplicacion,
pero en lo poco que alcance a hacer, tuve problemas con la optimización
del guardado, el cual lo intente hacer por batch, pero no logre reducir 
el tiempo a lo deseado, sin embargo creo que es la manera de abordar
el ejercicio.

Creo que una solucion distribuida podria ayudar a abordar mejor la solucion,
algo como un apache spark para procesar el archivo de forma distribuida.

    