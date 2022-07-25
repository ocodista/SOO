import { EstanteType } from '../types'
import { PrateleirasMock } from './PrateleiraMock'

export const EstanteMock: EstanteType[] = [
  {
    id: 1,
    descricao: 'Alecrim',
    qtdNichosPorPrateleira: 3,
    qtdPrateleiras: 3,
    prateleiras: PrateleirasMock
  },
  {
    id: 2,
    descricao: 'Tomate',
    qtdNichosPorPrateleira: 3,
    qtdPrateleiras: 3,
    prateleiras: []
  },
  {
    id: 3,
    descricao: 'Samambaia',
    qtdNichosPorPrateleira: 3,
    qtdPrateleiras: 3,
    prateleiras: []
  }
]
