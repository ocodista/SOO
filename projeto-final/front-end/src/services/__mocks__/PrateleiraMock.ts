import { PrateleiraType } from '../types'
import { NichosMock } from './NichoMock'

export const PrateleirasMock: PrateleiraType[] = [
  {
    id: 1,
    idEstante: 1,
    posicaoVertical: 0,
    nichos: NichosMock
  },
  {
    id: 2,
    idEstante: 1,
    posicaoVertical: 1,
    nichos: []
  },
  {
    id: 3,
    idEstante: 1,
    posicaoVertical: 2,
    nichos: []
  }
]
