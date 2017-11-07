package com.homework.demo;

import com.homework.demo.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value="/api/v1/portfolios", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllPortfolioName() {
        return portfolioService.getAllPortfolioNames();
    }

    @RequestMapping(value="/api/v1/portfolios/{portfolioName}", method = RequestMethod.GET)
    public @ResponseBody HashMap<String, Stock> getSinglePortfolio(@PathVariable(value = "portfolioName") String portfolioName) {
        return portfolioService.getStockList(portfolioName);
    }

    @RequestMapping(value="/api/v1/portfolios/", method = RequestMethod.POST)
    public @ResponseBody String setPortfolio(@RequestParam(value = "portfolioName") String portfolioName) {
        portfolioService.setPortfolioName(portfolioName);
        return "Success";
    }

    @RequestMapping(value="/api/v1/portfolios/", method = RequestMethod.DELETE)
    public @ResponseBody String deletePortfolio(@RequestParam(value = "portfolioName") String portfolioName) {
        return portfolioService.deletePortfolioName(portfolioName);
    }

    @RequestMapping(value="/api/v1/portfolios/{portfolioName}/{ticker}", method = RequestMethod.POST)
    public @ResponseBody Stock setPosition(
            @PathVariable(value = "portfolioName") String portfolioName, @PathVariable(value = "ticker") String ticker,
            @RequestParam(value = "marketValue") Double marketValue) {
        return portfolioService.addStock(portfolioName, ticker, marketValue);
    }

    @RequestMapping(value="/api/v1/portfolios/{portfolioName}/{ticker}", method = RequestMethod.DELETE)
    public @ResponseBody String deletePosition(
            @PathVariable(value = "portfolioName") String portfolioName, @PathVariable(value = "ticker") String ticker) {
        return portfolioService.deleteStock(portfolioName, ticker);
    }
//
//    @RequestMapping(value = "/api/v1/portfolios/net-asset-value", method = RequestMethod.GET)
//    public @ResponseBody void aggregateMarketValue(
//            return portfolioService.
//    )
}
