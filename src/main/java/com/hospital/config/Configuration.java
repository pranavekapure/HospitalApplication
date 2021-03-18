package com.hospital.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	/*
	 * @Bean public ProducerFactory getProducerFactory() {
	 * 
	 * Map<String, Object> configs = new HashMap();
	 * configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	 * configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class); return new DefaultKafkaProducerFactory<>(configs); }
	 */

	/*
	 * @Bean public KafkaTemplate<String, Integer> getRestTemplate() { return new
	 * KafkaTemplate<>(getProducerFactory()); }
	 */
}
