const filterMovies = (movies, searchTerm, sort) => {
  return movies
    // Filtrar las películas según el término de búsqueda
    .filter((movie) => {
      return movie.title.toLowerCase().includes(searchTerm.toLowerCase());
    })
    // Ordenar las películas según el criterio de ordenación
    .sort((a, b) => {
      if (sort === 'year-asc') {
        return a.year - b.year; // Orden ascendente por año
      } else if (sort === 'year-desc') {
        return b.year - a.year; // Orden descendente por año
      } else if (sort === 'rating-asc') {
        return a.personalRating - b.personalRating; // Orden ascendente por valoración
      } else if (sort === 'rating-desc') {
        return b.personalRating - a.personalRating; // Orden descendente por valoración
      } else {
        return 0; // Sin orden específico
      }
    });
};

export default filterMovies;