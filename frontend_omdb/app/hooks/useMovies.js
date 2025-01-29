import { useState, useEffect } from 'react';

const useMovies = () => {
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/omdb/harrypotter');
        
        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message);
        }

        const data = await response.json();
        setMovies(data);
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchMovies();
  }, []);

  return { movies, loading, error };
};

export default useMovies;