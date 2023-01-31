package com.test
data class ListModel(
    var adult: Boolean = false,
    var backdrop_path: String = "",
    var budget: Long = 0,
    var homepage: String = "",
    var id: Int = 0,
    var imdb_id: String = "",
    var original_language: String = "",
    var original_title: String = "",
    var overview: String = "",
    var popularity: Long = 0,
    var poster_path: String = "",
    var release_date: String = "",
    var revenue: String = "",
    var runtime: Long = 0,
    var status: String = "",
    var tagline: String = "",
    var title: String = "",
    var video: Boolean = false,
    var vote_average: Long = 0,
    var vote_count: Long = 0,
    /*var genres: ArrayList<GenresModel>? = null,
    var productionCompany: ArrayList<ProductionCompaniesModel> ?= null,
    var productionCountry: ArrayList<ProductionCountriesModel> ?= null,
    var spokenLanguage: ArrayList<SpokenLanguagesModel> ?= null
    var genres: ArrayList<Genres>,
    var productionCompany: ArrayList<ProductionCompanies>,
    var productionCountry: ArrayList<ProductionCountries>,
    var spokenLanguage: ArrayList<SpokenLanguages>*/
)
data class Genres(var id: Int = 0, var name: String = "")
data class ProductionCompanies(var id: Int = 0, var logo_path: String = "", var name: String = "", var origin_country: String = "")
data class ProductionCountries(var iso_3166_1: String = "", var name: String = "")
data class SpokenLanguages(var english_name: String = "", var iso_639_1: String = "", var name: String = "")
