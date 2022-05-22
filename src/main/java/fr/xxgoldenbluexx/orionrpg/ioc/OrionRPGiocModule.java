package fr.xxgoldenbluexx.orionrpg.ioc;

import com.google.inject.AbstractModule;

import fr.xxgoldenbluexx.orionrpg.OrionRPG;
import fr.xxgoldenbluexx.orionrpg.data.IPlayerWrapperRepository;
import fr.xxgoldenbluexx.orionrpg.data.yaml.YamlPlayerWrapperRepository;

public class OrionRPGiocModule extends AbstractModule {

	@Override
	protected void configure() {
		super.configure();
		bind(OrionRPG.class).toInstance(OrionRPG.main);
		bind(IPlayerWrapperRepository.class).to(YamlPlayerWrapperRepository.class);
	}
	
}
