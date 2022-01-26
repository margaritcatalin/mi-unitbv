import { TestBed, inject } from '@angular/core/testing';

import { GetCarListService } from './get-car-list.service';

describe('GetCarListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetCarListService]
    });
  });

  it('should be created', inject([GetCarListService], (service: GetCarListService) => {
    expect(service).toBeTruthy();
  }));
});
