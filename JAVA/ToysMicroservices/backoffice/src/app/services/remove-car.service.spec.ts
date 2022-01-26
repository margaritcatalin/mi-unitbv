import { TestBed, inject } from '@angular/core/testing';

import { RemoveCarService } from './remove-car.service';

describe('RemoveCarService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RemoveCarService]
    });
  });

  it('should be created', inject([RemoveCarService], (service: RemoveCarService) => {
    expect(service).toBeTruthy();
  }));
});
