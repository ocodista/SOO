import { NichoType } from '../types'
import { DispositivosMock } from './DispositivosMock'
import { PlantasMock } from './PlantasMock'

export const NichosMock: NichoType[] = [
  {
    id: 1,
    idPrateleira: 1,
    posicaoHorizontal: 0,
    dispositivos: [
      DispositivosMock[0],
      DispositivosMock[1],
      DispositivosMock[2],
      DispositivosMock[3]
    ],
    plantas: [
      PlantasMock[0]
    ]
  },
  {
    id: 1,
    idPrateleira: 1,
    posicaoHorizontal: 1,
    dispositivos: [],
    plantas: []
  },
  {
    id: 1,
    idPrateleira: 1,
    posicaoHorizontal: 2,
    dispositivos: [],
    plantas: []
  }
]
