<button class="btn btn-lg bg-transparent hidden" style="position: fixed; right: 10px; bottom: 10px" id="back-top">
	<i class="fa fa-arrow-circle-up fa-2x" aria-hidden="true"></i>
</button>
<style>
	.hidden {
		display: none;
	}
</style>
<script>
	document.addEventListener('scroll', e => {
		console.log(document.body.getBoundingClientRect().y)
		if (document.body.getBoundingClientRect().y === 0) {
			document.querySelector("#back-top").classList.add("hidden");
		} else {
			document.querySelector("#back-top").classList.remove("hidden");
		}
	});
	document.querySelector("#back-top").addEventListener('click', () => window.scrollTo({ top: 0, left: 0, behavior: 'smooth'}));
</script>