'use client';

import { useState } from 'react';
import Navbar from './components/Navbar';
import Input from './components/Input';
import Filter from './components/Filter';
import MovieCard from './components/MovieCard';
import useMovies from './hooks/useMovies';
import filterMovies from './hooks/filterMovies';

export default function Home() {
  // Obtener las películas, el estado de carga y el estado de error del hook useMovies
  const { movies, loading, error } = useMovies();
  
  // Estado local para almacenar el término de búsqueda
  const [searchTerm, setSearchTerm] = useState('');
  
  // Estado local para almacenar el criterio de ordenación
  const [sort, setSort] = useState('');

  // Manejador de eventos para cambiar el término de búsqueda
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  // Manejador de eventos para cambiar el criterio de ordenación
  const handleSortChange = (sort) => {
    setSort(sort);
  };

  // Filtrar y ordenar las películas según el término de búsqueda y el criterio de ordenación
  const filteredMovies = filterMovies(movies, searchTerm, sort);

  return (
    <div className="min-h-screen text-gray-200">
      {/* Barra de navegación */}
      <Navbar />
      <div>
        <div className="p-4">
          {/* Título de la página */}
          <h1 className="text-3xl text-white font-bold mb-4">
            Peliculas
          </h1>
          {/* Contenedor de búsqueda y filtro */}
          <div className="flex flex-col sm:flex-row justify-start items-start space-y-4 sm:space-y-0 sm:space-x-4">
            {/* Componente de entrada para buscar películas */}
            <Input value={searchTerm} onChange={handleSearchChange} />
            {/* Componente de filtro para ordenar las películas */}
            <Filter onSortChange={handleSortChange} />
            {loading && <p>Cargando...</p>}
            {error && <p style={{ color: 'red' }}>{error}</p>}
          </div>
          {/* Mostrar el número de películas filtradas */}
          <div className="mt-4 font-semibold text-gray-400">
            <p>
              {filteredMovies.length} Items
            </p>
          </div>
          {/* Contenedor de tarjetas de películas */}
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 mt-4">
            {filteredMovies.map((movie) => (
              <MovieCard key={movie.imdbID} title={movie.title} poster={movie.poster} personalRating={movie.personalRating} year={movie.year} />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}