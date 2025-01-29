import { useState, useEffect } from 'react';
import axios from 'axios';

const useMovies = () => {
  // Estado para almacenar las películas
  const [movies, setMovies] = useState([]);
  // Estado para manejar el estado de carga
  const [loading, setLoading] = useState(true);
  // Estado para manejar los errores
  const [error, setError] = useState(null);

  // useEffect para realizar la solicitud de datos cuando el componente se monta
  useEffect(() => {
    // Función asincrónica para obtener las películas
    const fetchMovies = async () => {
      try {
        // Realizar la solicitud a la API usando la variable de entorno
        const response = await axios.get(`${process.env.NEXT_PUBLIC_API_URL}/omdb/harrypotter`);
        
        // Actualizar el estado de las películas
        setMovies(response.data);
      } catch (error) {
        // Manejar errores del backend
        if (error.response) {
          setError(error.response.data.message);
        } else {
          setError('Error al conectar con el servidor');
        }
      } finally {
        // Actualizar el estado de carga
        setLoading(false);
      }
    };

    // Llamar a la función para obtener las películas
    fetchMovies();
  }, []);

  return { movies, loading, error };
};

export default useMovies;