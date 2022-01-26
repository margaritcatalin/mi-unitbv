import { TestBed, inject } from '@angular/core/testing';

import { GetCarService } from './get-car.service';

describe('GetCarService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetCarService]
    });
  });

  it('should be created', inject([GetCarService], (service: GetCarService) => {
    expect(service).toBeTruthy();
  }));
});
