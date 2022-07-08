export const wait = async (seconds) => {
  console.log(`Waiting ${seconds}s...`)
  await new Promise(r => setTimeout(r, seconds * 1000))
}