var app = angular.module('StockManager', ['ngRoute','ngResource','ui.bootstrap']);

		app.config(function($routeProvider){
				$routeProvider
				.when('/',
				{
					controller: 'ListStockController',
					templateUrl: '/views/stocks.html'
				})
				.when('/addStock',
				{
					controller: 'AddStockController',
					templateUrl: '/views/addStock.html'
				})
				.when('/editStock:id',
				{
					controller: 'EditStockController',
					templateUrl: '/views/editStock.html'
				})
				.otherwise({
					redirectTo: '/#'
				})

		});
		