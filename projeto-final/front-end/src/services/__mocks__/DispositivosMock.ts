import { DispositivoType } from '../types'
import { CategoriaDispositivoMock } from './CategoriaDispositivosMock'
import { TipoDispositivoMock } from './TipoDispositivosMock'

export const DispositivosMock: DispositivoType[] = [
  {
    id: 1,
    idNicho: 1,
    categoriaDispositivo: CategoriaDispositivoMock[0],
    tipoDispositivo: TipoDispositivoMock[1],
    value: 30
  },
  {
    id: 2,
    idNicho: 1,
    tipoDispositivo: TipoDispositivoMock[0],
    value: 1
  },
  {
    id: 3,
    idNicho: 1,
    categoriaDispositivo: CategoriaDispositivoMock[1],
    tipoDispositivo: TipoDispositivoMock[1],
    value: 10
  },
  {
    id: 4,
    idNicho: 1,
    categoriaDispositivo: CategoriaDispositivoMock[2],
    tipoDispositivo: TipoDispositivoMock[1],
    value: 20
  }
]
