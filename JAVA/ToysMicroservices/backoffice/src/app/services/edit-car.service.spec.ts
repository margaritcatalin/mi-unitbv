import { TestBed, inject } from '@angular/core/testing';

import { EditCarService } from './edit-car.service';

describe('EditCarService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditCarService]
    });
  });

  it('should be created', inject([EditCarService], (service: EditCarService) => {
    expect(service).toBeTruthy();
  }));
});
