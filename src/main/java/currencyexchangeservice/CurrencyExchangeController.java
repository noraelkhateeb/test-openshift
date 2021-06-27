package currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	private ExchangeValueRepository repository; 
	
	@GetMapping("/CurrencyExchange/from/{from}/to/{to}")
	public ExchangeValue retrieveexchangevalue(@PathVariable String from,@PathVariable String to) {
		
		  ExchangeValue exchangevalue =repository.findByFromAndTo(from, to);
		 
				
				//ExchangeValue exchval=	new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
		     exchangevalue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		     
		     logger.info("{}",exchangevalue);
				
				return exchangevalue;
	
	}

}
