let button = document.getElementById("genTable");

button.addEventListener("click", 

    ( getDatos = async () => {
        let dimension = document.getElementById("matrix_dim").value;
        let table = document.createElement("table");
        let counter = 0;

        console.log("Hola");
        //Nuestro objetivo es generar una table que coloree los numeros impares y que la cree dinamicamente
        for(let i=0; i < dimension;i++)
        {
            //Filas
            let row = document.createElement("tr");
            for (let j=0; j <dimension;j++)
            {
                let heading = document.createElement("th");
                heading.innerHTML= counter.toString();
                if(counter % 2 == 0)
                {
                    heading.style.color= "blue";
                }
                else
                {
                    heading.style.color= "red";
                }
                //Columnas
                
                row.appendChild(heading);
                counter++;
            }
            table.appendChild(row);
        }
    
        document.getElementById('table').appendChild(table);
    })

)
