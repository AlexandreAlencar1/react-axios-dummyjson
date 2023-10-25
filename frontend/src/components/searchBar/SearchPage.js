import React from "react";
import { Route, Routes } from "react-router-dom";
import SearchBar from "./SearchBar";
import SearchResultsList from "./SearchResultsList";

function SearchPage() {
  return (
    <div className="search-page">
      <Route path="/search" element={<SearchBar />} />
      <Route path="/search/results" element={<SearchResultsList />} />
    </div>
  );
}

export default SearchPage;
