package com.faforever.client.fa.relay.ice;

import com.faforever.client.player.PlayerService;
import com.faforever.client.remote.FafService;
import com.google.common.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class IceAdapterImplTest {

  @Mock
  private IceAdapterImpl instance;
  @Mock
  private ApplicationContext applicationContext;
  @Mock
  private PlayerService playerService;
  @Mock
  private EventBus eventBus;
  @Mock
  private FafService fafService;

  @Before
  public void setUp() throws Exception {
    instance = new IceAdapterImpl(applicationContext, playerService, eventBus, fafService);
  }

  @Test
  public void onIceAdapterStateChanged() throws Exception {
  }

  @Test
  public void onGpgGameMessage() throws Exception {
  }

  @Test
  public void start() throws Exception {
  }

  @Test
  public void stop() throws Exception {
  }

}
