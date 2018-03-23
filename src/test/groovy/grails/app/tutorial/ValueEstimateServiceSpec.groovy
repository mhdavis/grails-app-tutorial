package grails.app.tutorial

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ValueEstimateService)
class ValueEstimateServiceSpec extends Specification {

    void setupSpec() {
      mockDomain Make
      mockDomain Model
      mockDomain Vehicle
    }

    void testEstimateRetrieval() {
      given: 'a vehicle'
      def make = new Make(name: 'Test')
      def model = new Model(name: 'Test', make: make)
      def vehicle = new Vehicle(year: 2000, make: make, model: model, name: 'Test')

      when: 'service is called'
      def estimate = service.getEstimate(vehicle)

      then: 'a non-zero result is returned'
      estimate > 0

      and: 'estimate is not too large'
      estimate < 1000000
    }

}
