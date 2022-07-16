import { Grid } from '@chakra-ui/react'
import { NicheDetail, NicheDetailProps } from './NicheDetail'

type Niche = NicheDetailProps;

const mockNiche: Array<Niche> = [
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: true,
    moisture: 25,
    nicheId: 1
  },
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: false,
    moisture: 25,
    nicheId: 3
  },
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: false,
    moisture: 25,
    nicheId: 4
  }
]

export function NicheArea () {
  function parseNicheList (niches: Array<NicheDetailProps>) {
    const newNicheList = new Array<NicheDetailProps>(9)

    niches.forEach(niche => {
      if (niche.nicheId) {
        newNicheList[niche.nicheId] = niche
      }
    })

    for (let index = 0; index < newNicheList.length; index++) {
      if (!newNicheList[index]) {
        newNicheList[index] = { ...newNicheList[index], isEmpty: true }
      }
    }

    return newNicheList
  }

  const orderedNiche = parseNicheList(mockNiche)

  return (
    <Grid
      templateColumns="repeat(3, 1fr)"
      templateRows="repeat(3, 1fr)"
      gap="8px"
      height="100%"
    >
      {orderedNiche.map((niche, index) => {
        return (
          <NicheDetail
          key={index}
          nicheId={niche.nicheId}
          isLightOn={niche.isLightOn}
          isWaterOn={niche.isWaterOn}
          moisture={niche.moisture}
          temperature={niche.temperature}
          isEmpty={niche.isEmpty}
        />
        )
      })}
    </Grid>
  )
}
