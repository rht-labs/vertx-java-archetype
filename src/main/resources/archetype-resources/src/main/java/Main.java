#set( $symbol_pound = '#' )                                                                                                                                                                                                              
#set( $symbol_dollar = '$' )                                                                                                                                                                                                             
#set( $symbol_escape = '\' )                                                                                                                                                                                                             
package ${package};

import io.vertx.core.AbstractVerticle;

/**
 *
 */
public class Main extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.setPeriodic(3000, res -> {
      System.out.println("Periodic event triggered.");
    });
  }
}
